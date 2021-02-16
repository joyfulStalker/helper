package co.imdo.perfect;

import co.imdo.perfect.getui.api.GeTuiService;
import co.imdo.perfect.getui.po.PushMessageVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGetuiConfig {

    @Autowired
    private GeTuiService geTuiService;


    @Test
    public void testGetui() {


        PushMessageVo pushMessage = new PushMessageVo();
        pushMessage.setCid("03c91878ea843491c09690f801913e96");
        pushMessage.setMessage("sa");
        pushMessage.setTitle("sdaf");
        geTuiService.push(pushMessage);
    }

}
