import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/*
*
* */
public class RandomPasssword {
    public static void main(String[] args) {

        showUI();


    }

    public static void  showUI(){

        JFrame jf=new JFrame();
        jf.setTitle("随机密码生产器");
        jf.setSize(500,120);
        //设置退出进程的方法
        jf.setDefaultCloseOperation(3);
        //设置居中显示用3
        jf.setLocationRelativeTo(null);

        //流式布局管理器
        FlowLayout flow = new FlowLayout();
        jf.setLayout(flow);  //给窗体设置为流式布局——从左到右然后从上到下排列自己写的组件顺序
        JLabel jl =new JLabel("输入密码位数8~18位：");
        jf.add(jl);
        //文本框
        JTextField jtf = new JTextField();
        Dimension dm = new Dimension(50, 20);
        //(除了JFrame)其它所有组件设置大小都是该方法
        jtf.setPreferredSize(dm);
        jf.add(jtf);

        //复选框
        JCheckBox jcb = new JCheckBox("大写字母");
        jf.add(jcb);

        JCheckBox jcb2 = new JCheckBox("小写字母");
        jf.add(jcb2);

        JCheckBox jcb3 = new JCheckBox("特殊字符");
        jf.add(jcb3);

        //按钮
        JButton jbu = new JButton("生成");
        jf.add(jbu);   //给窗体添加一个按钮对象
        JTextField jtf2 = new JTextField();
        jtf2.setPreferredSize(new Dimension(400, 30));
        jf.add(jtf2);


        jbu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf2.setText(getPasswordOne(jcb.isSelected(),jcb2.isSelected(),jcb3.isSelected(),Integer.parseInt(jtf.getText())));
            }
        });

        jf.setVisible(true);   //设置可见，放在代码最后一句

    }

    private static String getPasswordOne(boolean upperCase,boolean lowerCase, boolean spaceCharCase,int length){
        String[] num={"0","1","2","3","4","5","6","7","8","9"};
        String[] upper={"A","B","C","D","E","G","F","H","I","J","K","L","M","N","O","P","W","Q","R","S","T","U","V","X","Y","Z",};
        String[] lower= {"a","s","d","f","g","h","j","k","l","q","w","e","r","t","y","u","i","o","p","z","x","c","v","b","n","m"};
        String[] spaceChar= {"~","!","@","#","$","%","^"};

        Random random = new Random();
        if(upperCase){
            int numLength = num.length;
            num=Arrays.copyOf(num,num.length+upper.length);
            System.arraycopy(upper,0,num,numLength,upper.length);
        }
        if(lowerCase){
            int numLength = num.length;
            num=Arrays.copyOf(num,num.length+lower.length);
            System.arraycopy(lower,0,num,numLength,lower.length);
        }
        if(spaceCharCase){
            int numLength = num.length;
            num=Arrays.copyOf(num,num.length+spaceChar.length);
            System.arraycopy(spaceChar,0,num,numLength,spaceChar.length);
        }
        String password = "";
        for (int i=0;i<length;i++ ){
            password+=num[random.nextInt(num.length)];
        }
        return password;
    }
}
