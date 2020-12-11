package helper.web;

import common.common.HttpMethod;
import common.common.base.R;
import helper.service.ITtNoteService;
import helper.vo.note.NoteQueryVo;
import helper.vo.note.NoteVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author liuSongLin
 * @since 2020-07-15
 */
@RestController

@Api(value = "笔记", tags = "笔记")
@RequestMapping("/note")
public class TtNoteController {
    @Autowired
    private ITtNoteService noteService;


    @ResponseBody
    @PostMapping("/addNote")
    @ApiOperation(value = "1、添加笔记",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "1、添加笔记",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R saveNote(@Validated(NoteVo.CheckInsert.class) @RequestBody NoteVo noteVo) {
        noteService.saveNote(noteVo);
        return R.of();
    }


    @ResponseBody
    @PostMapping("/list")
    @ApiOperation(value = "2、笔记列表",
            httpMethod = HttpMethod.POST,
            response = R.class,
            notes = "2、笔记列表",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R list(@Validated(NoteQueryVo.Check.class) @RequestBody NoteQueryVo queryVo) {

        return R.of(noteService.noteList(queryVo));
    }


    @ResponseBody
    @GetMapping("/detail")
    @ApiOperation(value = "3、笔记详情",
            httpMethod = HttpMethod.GET,
            response = R.class,
            notes = "3、笔记详情",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)

    public R detail(@RequestParam Integer id) {
        return R.of(noteService.detail(id));
    }
}
