import axios from 'axios'
import { Message } from 'element-ui'

console.log("---" + process.env.NODE_ENV)
// 动态选择环境，测试用代理，上线用真实地址，老子就是这么牛
const service =
    process.env.NODE_ENV === 'development' ?
        axios.create({
            baseURL: '/mypath', // api的base_url
            timeout: 100000// 请求超时时间
        }) :
        axios.create({
            baseURL: './', // api的base_url
            timeout: 100000// 请求超时时间
        })
    ;

/**
 * 这里使用service来为自己的封装做拦截器，而官方文档使用的axios是针对的是全局的baseURL
 */
service.interceptors.request.post
service.interceptors.request.use(config => {
    config.headers['token'] = localStorage.getItem("token");
    if(config.method === 'post'){
        config.headers['Content-Type'] = 'application/json';
    }
    return config
}, err => {
    Message({
        showClose: true,
        message: err,
        type: 'warning'
    })
    return Promise.reject(err);
}
);
/**
 * 这里使用service来为自己的封装做拦截器，而官方文档使用的axios是针对的是全局的baseURL
 */
service.interceptors.response.use(
    response => {
        // console.log(this);
        //异常统一处理
        if (response.data.code != 1) {
            Message({
                showClose: true,
                message: response.data.msg,
                type: 'warning'
            })
        }
        return response;
    }
);
export default service;