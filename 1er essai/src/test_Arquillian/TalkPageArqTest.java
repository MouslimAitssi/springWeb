//package test_Arquillian;
//import static org.junit.Assert.assertEquals;
//
//import org.junit.runner.RunWith;
//
//@RunWith(Arquillian.class)
//public class TalkPageArqTest {
//
//    static final String MOI = "Stagiaire";
//
//    @Deployment(testable = false)
//    public static Archive<?> deploy() {
//        return Deployments.deploy();
//    }
//
//    @Drone WebDriver browser;
//    @ArquillianResource URL baseUrl;
//    @Page TalkArqPage talkPage;
//
//    @Test
//    public void should_full_list_have_some_lines() {
//        talkPage.open();
//        assertEquals("Liste des talks", 10, talkPage.initialList().size());
//    }
//
//    @Test
//    public void should_filtered_list_have_less_lines() {
//        talkPage.open();
//        assertEquals("Liste des talks", 2, talkPage.searchBySpeaker(MOI).size());
//    }
//}