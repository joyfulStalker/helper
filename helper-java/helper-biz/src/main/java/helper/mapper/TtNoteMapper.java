package helper.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import helper.entity.TtNote;
import helper.vo.note.NoteQueryVo;
import helper.vo.note.NoteVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper接口
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
public interface TtNoteMapper extends BaseMapper<TtNote> {

    /**
     * 列表查询
     *
     * @param queryVo
     * @return
     */
    IPage<NoteVo> selectNoteList(Page page, @Param("queryVo") NoteQueryVo queryVo, @Param("userId") Integer userId);

}