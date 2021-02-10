package co.imdo.perfect;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 解 n元一次方程
 */
@Slf4j
public class EquationSolution {

    private static final String X = "x";
    private static final String Y = "y";
    private static final String PLUS = "\\+";
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";
    private static final String EQU = "=";

    /**
     * 保留位数
     */
    private static final int scale = 2;
    /**
     * BigDecimal保留小数的方式
     */
    private static final int ROUND_TYPE = BigDecimal.ROUND_HALF_UP;
    /**
     * 最终的解
     */
    public static Map<String, String> pv = Maps.newHashMap();
    /**
     * 还需要求解的元素
     */
    public static Map<String, String> pvForCalculate = Maps.newConcurrentMap();
    /**
     * 已解出来的参数 带入方程式
     */
    public static Map<String, String> daiRuMap = Maps.newHashMap();
    /**
     * 是否计算完成标识  true计算完成
     */
    public static boolean endFlag = false;
    /**
     * 待求方程组
     */
    public static List<Map<String, String>> decoListStatic = Lists.newArrayList();

    public static void main(String[] args) {
        //1 2 3 1
//        String e1 = "x+y=3";
//        String e2 = "2x+3y=8";
//        String e3 = "2x+3y=9";
//        String e3 = "3x+4y+3z=20";
//        String e1 = "x+y+z=6";
//        String e2 = "2x+3y+4z=20";
//        String e3 = "3x+4y+3z=20";
        String e1 = "x+y+z+f=7";
        String e2 = "2x+3y-4z+2f=10";
        String e3 = "3x+4y+3z+3f=23";
        String e4 = "3x+4y+3z-f=19";
//        calculate(e1, e2, e3);
        calculate(e1, e2, e3, e4);
        log.info(JSON.toJSONString(pv));
    }

    public static void calculate(String... expressions) {
        //解析表达式 处理成要计算的模板
        decoListStatic = getDeco(expressions);
        log.info(JSON.toJSONString(decoListStatic));
        solution(decoListStatic);
    }

    private static void solution(List<Map<String, String>> decoList) {
        if (CollectionUtils.isEmpty(decoList) || endFlag) {
            return;
        }
        int solvedNum = 0;

        for (Map<String, String> deco : decoList) {
            if (deco.keySet().size() == 2) {
                //求解
                solve(deco);
                //把求出的值带入等式，刷新表达式
                reFreshDecoList(decoListStatic);
                //重新计算
                solution(decoListStatic);
                return;
            } else if (deco.keySet().size() == 1) {
                solvedNum += 1;
            }
        }

        if (solvedNum == decoListStatic.size()) {
            log.info("当前循环所有的值已经求出来");
            endFlag = true;
            return;
        }

        for (String param : pvForCalculate.keySet()) {

            log.info("要消除的参数是：" + param);
            List<Map<String, String>> decoCopyList = Lists.newArrayList();
            //求公倍数
            List<BigDecimal> coefficients = Lists.newArrayList();
            for (Map<String, String> deco : decoList) {
                Map<String, String> decoCopy = Maps.newHashMap();
                BeanUtil.copyProperties(deco, decoCopy);
                if (deco.keySet().size() > 1 && deco.get(param) != null) {
                    coefficients.add(new BigDecimal(deco.get(param)));
                }
                decoCopyList.add(decoCopy);
            }
            if (CollectionUtil.isEmpty(coefficients)) {
                continue;
            }
            BigDecimal beiShu = beiShu(coefficients);

            //消元后的
            List<Map<String, String>> solvedDecoList = Lists.newArrayList();
            Map<String, String> lastDecoCopy = null;

            for (Map<String, String> decoCopy : decoCopyList) {
                Map<String, String> copy = Maps.newHashMap();
                if (decoCopy.get(param) != null) {
                    //乘以倍数
                    BigDecimal bs = beiShu.divide(new BigDecimal(decoCopy.get(param)), scale, ROUND_TYPE);
                    for (String p : decoCopy.keySet()) {
                        decoCopy.put(p, new BigDecimal(decoCopy.get(p)).multiply(bs).toString());
                        copy.put(p, decoCopy.get(p));
                    }
                    if (!CollectionUtils.isEmpty(lastDecoCopy)) {
                        Map<String, String> calculateMap = Maps.newHashMap();
                        for (String pp : pvForCalculate.keySet()) {
                            //消元
                            //s = s1 - s2
                            String s = "";
                            String s1 = decoCopy.get(pp);
                            String s2 = lastDecoCopy.get(pp);
                            if (StringUtils.isBlank(s1) && StringUtils.isBlank(s2)) {
                                s = "";
                            } else if (StringUtils.isBlank(s2)) {
                                s = s1;
                            } else if (StringUtils.isBlank(s1)) {
                                s = "-" + s2;
                                s = s.replace("--", "");
                            } else {
                                s = new BigDecimal(s1).subtract(new BigDecimal(s2)).toString();
                            }
                            if (StringUtils.isBlank(s) || new BigDecimal(s).compareTo(BigDecimal.ZERO) == 0) {
                                log.info("该参数被消除：" + pp);
                            } else {
                                calculateMap.put(pp, s);
                            }
                        }
                        calculateMap.put(EQU, new BigDecimal(decoCopy.get(EQU)).subtract(new BigDecimal(lastDecoCopy.get(EQU))).toString());
                        solvedDecoList.add(calculateMap);
                    }
                }
                lastDecoCopy = Maps.newHashMap();
                for (String key : copy.keySet()) {
                    lastDecoCopy.put(key, copy.get(key));
                }
            }
            solution(solvedDecoList);
        }
    }


    /**
     * 公倍数
     *
     * @return
     */
    public static BigDecimal beiShu(List<BigDecimal> coefficients) {
        BigDecimal res = BigDecimal.ONE;
        for (BigDecimal coefficient : coefficients) {
            res = res.multiply(coefficient);
        }
        return res;
    }

    private static void solve(Map<String, String> map) {
        if (map.size() != 2) {
            return;
        }
        String left = "";
        String right = "";
        String p = "";
        for (String p1 : map.keySet()) {
            if (p1.equals(EQU)) {
                right = map.get(p1);
            } else {
                left = map.get(p1);
                p = p1;
            }
        }
        String value = new BigDecimal(right).divide(new BigDecimal(left), scale, ROUND_TYPE).toString();
        if (StringUtils.isBlank(pv.get(p))) {
            pv.put(p, value);
            daiRuMap.put(p, value);
        } else {
            Assert.isTrue(pv.get(p).equals(value), "参数" + p + "多解");
        }
    }

    /**
     * 刷新DecoList 并把daiRuMap缓存清掉
     *
     * @param decoList
     */
    private static void reFreshDecoList(List<Map<String, String>> decoList) {
        if (CollectionUtils.isEmpty(daiRuMap)) {
            return;
        }
        for (String daiRu : daiRuMap.keySet()) {
            if (StringUtils.isNotBlank(daiRuMap.get(daiRu))) {
                for (Map<String, String> deco : decoList) {
                    if (deco.size() <= 1) {
                        continue;
                    }
                    BigDecimal value = new BigDecimal(deco.get(daiRu)).multiply(new BigDecimal(daiRuMap.get(daiRu)));
                    BigDecimal subtract = new BigDecimal(deco.get(EQU)).subtract(value);
                    deco.put(EQU, subtract.toString());
                    deco.remove(daiRu);
                    if (deco.size() == 1) {
                        Assert.isTrue(BigDecimal.ZERO.compareTo(new BigDecimal(deco.get(EQU))) == 0, "该方程组无解");
                    }
                }
                //把当前的值去掉 下次就不做该参数的替换了
                daiRuMap.remove(daiRu);
                pvForCalculate.remove(daiRu);
            }
        }
        log.info(JSON.toJSONString(decoList));
    }


    private static List<Map<String, String>> getDeco(String[] expressions) {
        List<Map<String, String>> deco = Lists.newArrayList();
        for (String expression : expressions) {
            String[] split = expression.split(EQU);
            Assert.isTrue(split.length == 2, "请检查表达式：" + expression + "是否正确");
            Map<String, String> exMap = Maps.newHashMap();
            exMap.put(EQU, split[1]);
            String[] splitPlus = split[0].replace(SUB, "+-").split(PLUS);
            putToExMap(exMap, splitPlus);
            deco.add(exMap);
        }
        return deco;
    }

    /**
     * 2x
     * -2x
     * +2x
     *
     * @param es
     * @return
     */
    public static void putToExMap(Map<String, String> exMap, String... es) {
        for (String e : es) {
            char[] chars = e.toCharArray();
            String param = "";
            for (char c : chars) {
                if (97 <= c && c <= 122) {
                    param = new String(new char[]{c});
                    pv.put(param, "");
                    pvForCalculate.put(param, "");
                }
            }
            if (StringUtils.isNotBlank(param)) {
                e = e.replace(param, "");
                if (e.contains("-") && StringUtils.isBlank(e.replace("-", ""))) {
                    e = "-1";
                }

            }
            if (StringUtils.isBlank(param.replace("-", ""))) {

            }
            if (StringUtils.isBlank(e)) {
                e = "1";
            }
            exMap.put(param, e);
        }
    }

}
