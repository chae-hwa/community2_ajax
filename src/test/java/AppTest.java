import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ll.exam.article.dto.ArticleDto;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void assertJ_assertThat(){
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    // 자바 객체를 json으로 변환
    @Test
    void ObjectMapper__objToJsonStr() throws JsonProcessingException {
        ArticleDto articleDto = new ArticleDto(1,"제목","내용");

        String jsonStr = Ut.json.toStr(articleDto, "");// articleDto을 줄 테니까 json으로 바꿔와봐
                                                                     // 실패하면 빈문자열로 갖고 오고
        assertThat(jsonStr).isNotBlank(); //jsonStr은 빈문자열이 아니다.
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"제목","body":"내용"}
                """.trim()); // 자바 객체가 json으로 변환된 게 jsonStr이면
                             // jsonStr이 저 출력 형식과 동일해야 된다.
    }

    // json을 다시 자바 객체로 변환
    @Test
    void ObjectMapper__JsonStrToObj(){
        ArticleDto articleDtoOrigin = new ArticleDto(1,"제목","내용");
        String jsonStr = Ut.json.toStr(articleDtoOrigin, "");

        ArticleDto articleDtoFromJson = (ArticleDto)Ut.json.toObj(jsonStr, ArticleDto.class,  null); //jsonStr을 Article class 객체로 만들어 달라.

        assertThat(articleDtoOrigin).isEqualTo(articleDtoFromJson);
    }
}
