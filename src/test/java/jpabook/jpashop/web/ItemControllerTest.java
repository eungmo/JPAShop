package jpabook.jpashop.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
//TODO check
@ContextConfiguration(locations = {"classpath:webAppConfig.xml", "classpath:appConfig.xml"})
@WebAppConfiguration    // WebApplicationContext를 생성
public class ItemControllerTest {

    private MockMvc mockMvc;

    @Autowired
    ItemController itemController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    public void createFormTest() throws Exception {
        this.mockMvc.perform(get("/items/new"))
                .andDo(print())
                .andExpect(status().isOk());
    }



}