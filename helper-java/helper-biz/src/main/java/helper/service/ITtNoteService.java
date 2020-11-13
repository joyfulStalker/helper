package helper.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import helper.entity.TtNote;
import helper.vo.note.NoteQueryVo;
import helper.vo.note.NoteVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
public interface ITtNoteService extends IService<TtNote> {

    /**
     * 保存笔记
     *
     * @param noteVo
     */
    void saveNote(NoteVo noteVo);

    /**
     * @param id
     * @return
     */
    NoteVo detail(Integer id);

    /**
     * 笔记列表
     *
     * @param queryVo
     * @return
     */
    IPage<NoteVo> noteList(NoteQueryVo queryVo);
}
