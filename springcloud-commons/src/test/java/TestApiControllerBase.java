import com.codeme.springcloud.commons.controller.ApiControllerBase;
import com.codeme.springcloud.commons.dto.ApiResultDTO;
import com.codeme.springcloud.commons.vo.ApiResultBaseVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestApiControllerBase {

    private ApiControllerBase apiControllerBase;

    @BeforeEach
    public void setup() {
        this.apiControllerBase = new ApiControllerBase();
    }

    @Test
    public void okOfNull() {
        ResponseEntity entity = apiControllerBase.ok();
        System.out.println(entity);
        assertEquals(null, entity.getBody());
    }

    @Test
    public void okOfHasComplexTypeContent() {
        ResponseEntity<ApiResultDTO> entity = apiControllerBase.ok(new ApiResultDTO(200, "ok"));
        assertEquals(200, entity.getBody().getCode());
    }

    @Test
    public void okOfHasBasicTypeContent() {
        ArrayList<String> arr = new ArrayList();
        arr.add("jiangy");
        arr.add("wanglinling");
        ResponseEntity entity = apiControllerBase.ok(arr);
        assertEquals(arr.size(), ((ArrayList<String>)entity.getBody()).size());
    }

    @Test
    public void badRequestOfHasBasicTypeContent() {
        ResponseEntity<ApiResultBaseVO> entity = apiControllerBase.badRequest("没有找到内容");
        System.out.println(entity.getBody());
        assertEquals(400, entity.getStatusCodeValue());
        assertEquals(400, entity.getBody().getErrcode());
    }
}