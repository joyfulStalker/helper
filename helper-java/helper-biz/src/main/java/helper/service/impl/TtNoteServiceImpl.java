package helper.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import common.common.enums.LabelEnum;
import common.utils.AutoFillBaseDataUtil;
import common.utils.PageUtil;
import helper.entity.TtNote;
import helper.mapper.TtNoteMapper;
import helper.service.IRltLabelService;
import helper.service.ITtNoteService;
import helper.service.RedisService;
import helper.vo.note.LabelVo;
import helper.vo.note.NoteQueryVo;
import helper.vo.note.NoteVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class TtNoteServiceImpl extends ServiceImpl<TtNoteMapper, TtNote> implements ITtNoteService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private IRltLabelService rltNoteLabelService;

    @Override
    public void saveNote(NoteVo noteVo) {

        TtNote note = new TtNote();
        BeanUtil.copyProperties(noteVo, note);
        AutoFillBaseDataUtil.fillCreatedData(note);

        note.setTtUserId(redisService.getCurrentUser().getId());
        note.setCreateBy(redisService.getCurrentUser().getId());
        note.setCreateByName(redisService.getCurrentUser().getUserName());

        baseMapper.insert(note);

    }

    @Override
    public NoteVo detail(Integer id) {

        TtNote note = baseMapper.selectById(id);
        NoteVo noteVo = new NoteVo();
        if (note == null) {
            return noteVo;
        }
        BeanUtil.copyProperties(note, noteVo);
        //处理标签
        List<LabelVo> labelList = rltNoteLabelService.getLabelList(note.getId(), LabelEnum.NOTE);
        if (CollectionUtil.isNotEmpty(labelList)) {
            noteVo.setLabelList(labelList);
        }
        return noteVo;
    }

    @Override
    public IPage<NoteVo> noteList(NoteQueryVo queryVo) {
        Integer userId = redisService.getCurrentUser(false).getId();
        return baseMapper.selectNoteList(PageUtil.getPage(queryVo), queryVo, userId);
    }
}
