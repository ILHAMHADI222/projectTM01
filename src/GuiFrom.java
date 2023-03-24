import RESMODEL.ResponeModel;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static com.sun.org.apache.xerces.internal.util.DOMUtil.setVisible;

public class GuiFrom {
    private JButton submitButton;
    private JTextField textField1;
    private JTextField textField2;
    private JButton Close;
    private JLabel hrgtertinggi;
    private JLabel totaldata;
    private JPanel rootpanel;



    public void DATAFARMASI(JFrame frame){
        initialize(frame);
        DataFarmasi();

        frame.setContentPane(rootpanel);
        setSize(new Dimension(450,470));
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        setVisible(true);

    }

    private void setVisible(boolean b) {
    }

    private void setSize(Dimension dimension) {
    }

    public void DataFarmasi() {
        submitButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()== submitButton) {

                    try {
                        URL url = new URL("\"https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM\"");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                        String inputline;
                        StringBuffer respone = new StringBuffer();
                        new StringBuffer();
                        while ((inputline = in.readLine()) != null) {
                            respone.append(inputline);

                        }
                        in.close();
                        JSONArray jsonArray = new JSONArray(respone.toString());
                        ArrayList<ResponeModel> parsedList= new ArrayList<>();
                        for (int i =0 ; i<jsonArray.length(); i++){
                            ResponeModel responeModel= new ResponeModel();
                            JSONObject myJSONObject= jsonArray.getJSONObject(i);
                            responeModel.setI_sell(myJSONObject.getString("sell"));
                            responeModel.setI_name(myJSONObject.getString("name"));
                            parsedList.add(responeModel);

                        }
                        for(int index= 0;index< parsedList.size(); index++ ){
                            int a = Integer.parseInt(parsedList.get(index).getI_sell());
                            if (a <= 2000){
                                System.out.println(parsedList.get(index).getI_sell());
                            }

                        }


                    } catch (MalformedURLException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                JOptionPane.showMessageDialog(rootpanel, "APAKAH ANDA AKAN SUBMIT?","INFOMASI",JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(rootpanel,"MAAF ANDA GAGAL SUBMIT","EROR",JOptionPane.ERROR_MESSAGE);
                int result= JOptionPane.showConfirmDialog(rootpanel,"APAKAH ANDA AKAN MELANJUTKAN?");
                if(result == JOptionPane.YES_NO_OPTION);
                String massage= JOptionPane.showInputDialog(rootpanel," masukan pesan anda:","INFORMASI",JOptionPane.INFORMATION_MESSAGE);

            }
        });

        Close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result=  JOptionPane.showConfirmDialog(rootpanel, "APAKAH ANDA AKAN KELUAR?");
                if (result== JOptionPane.YES_NO_OPTION);


            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        GuiFrom TM1 = new GuiFrom(frame);
        frame.setVisible(true);
        frame.pack();


    }
    public GuiFrom(JFrame jFrame){
        initialize(jFrame);

    }
    public void initialize(JFrame jFrame){

    }
}
