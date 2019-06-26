package bean.JavaConfigBean;

public class JaveBeanPlay {
    private JaveBeanDisc cd;

    public JaveBeanPlay(JaveBeanDisc cd) {
        this.cd = cd;
    }

    public void play(){
        cd.play();
    }
}
