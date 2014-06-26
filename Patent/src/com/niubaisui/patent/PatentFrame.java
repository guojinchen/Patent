/**
 * 
 */
package com.niubaisui.patent;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

import org.apache.http.client.ClientProtocolException;
import org.htmlparser.util.ParserException;

/**
 * @author Administrator
 * 
 */
public class PatentFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String numFMGB;
	private String numFMSQ;
	private String numSYXX;
	private String numWGSQ;
	private String params;
	/**
	 * 
	 */
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
	private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;

	public PatentFrame() {
		initComponents();
	}
	public javax.swing.JLabel getjLabel6() {
		return jLabel6;
	}
	public JTextArea getTextArea(){
		return jTextArea1;
	}
	
	public JProgressBar getProgress(){
		return jProgressBar1;
	}
	public String getNumFMGB() {
		return numFMGB;
	}

	public void setNumFMGB(String numFMGB) {
		this.numFMGB = numFMGB;
	}

	public String getNumFMSQ() {
		return numFMSQ;
	}

	public void setNumFMSQ(String numFMSQ) {
		this.numFMSQ = numFMSQ;
	}

	public String getNumSYXX() {
		return numSYXX;
	}

	public void setNumSYXX(String numSYXX) {
		this.numSYXX = numSYXX;
	}

	public String getNumWGSQ() {
		return numWGSQ;
	}

	public void setNumWGSQ(String numWGSQ) {
		this.numWGSQ = numWGSQ;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public javax.swing.JButton getjButton1() {
		return jButton1;
	}
	private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar1.setMaximum(100);
    	jProgressBar1.setMinimum(0);
    	jProgressBar1.setStringPainted(true);
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jRadioButton1.setText("发明公布");
        jRadioButton2.setText("发明授权");
        jRadioButton3.setText("实用新型");
        jRadioButton4.setText("外观设计");

        jLabel1.setText("申请日");

        jLabel2.setText("公开日");

        jLabel3.setText("申请人");

        jLabel4.setText("地址");

        jLabel5.setText("专利代理机构");
      

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setToolTipText("");
        jTextArea1.setLineWrap(true);
      
        jScrollPane1.setViewportView(jTextArea1);
//        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jLabel6.setText("进度条");

        jButton1.setText("抓取");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(68, 68, 68)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButton3)
                        .addGap(40, 40, 40)
                        .addComponent(jRadioButton4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton1)))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );

        pack();
    }                                                       
                                             
    /*
     * 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws ClientProtocolException, ParserException, IOException {                                         
        // TODO add your handling code here:
    	
    	/*
    	 * 得到用户输入信息
    	 */
    	numFMGB="";
    	numFMSQ="";
    	numSYXX="";
    	numWGSQ="";
    	if(jRadioButton1.isSelected()){
    		numFMGB="0";
    	}
    	if(jRadioButton2.isSelected()){
    		numFMSQ="0";
    	}
    	if(jRadioButton3.isSelected()){
    		numSYXX="0";
    	}
    	if(jRadioButton4.isSelected()){
    		numWGSQ="0";
    	}
    	if(!jRadioButton1.isSelected()&&!jRadioButton2.isSelected()&&!jRadioButton3.isSelected()&&!jRadioButton4.isSelected()){
    		numFMGB="0";
    		numFMSQ="0";
    		numSYXX="0";
    		numWGSQ="0";
    	}
    	
    	String shenqingri=jTextField1.getText();
    	String gongkairi=jTextField2.getText();
    	String shenqingren=jTextField3.getText();
    	String dizhi=jTextField4.getText();
    	String dailijigou=jTextField5.getText();
    	
    	String shenqingri_prefix="申请日=";
    	String gongkairi_prefix="公布（公告）日=";
    	String shenqingren_prefix="申请（专利权）人=";
    	String dizhi_prefix="地址=";
    	String dailijigou_prefix="专利代理机构=";
    	
    	params="";
    	if(!shenqingri.equals("")){
    		params=params+shenqingri_prefix+"'"+shenqingri+"'";
    	}
    	if(!gongkairi.equals("")){
    		params=params+gongkairi_prefix+"'"+gongkairi+"'";
    	}
    	if(!shenqingren.equals("")){
    		params=params+shenqingren_prefix+"'%"+shenqingren+"%'";
    	}
    	if(!dizhi.equals("")){
    		params=params+dizhi_prefix+"'"+dizhi+"'";
    	}
    	if(!dailijigou.equals("")){
    		params=params+dailijigou_prefix+"'"+dailijigou+"'";
    	}
    	System.out.println(params);
    	jButton1.setEnabled(false);
    	
    	//初始化解析
//    	PatentParser parser=new PatentParser(numFMGB, numFMSQ, numSYXX, numWGSQ, params);
//    	parser.parser("niubaisui.txt", this);
    	ThreadPatent patent=new ThreadPatent();
    	patent.setFrame(this);
    	patent.start();
    }                  
                                             

                           
	/**
	 * @param args
	 *            the command line arguments
	 * @throws IOException 
	 * @throws ParserException 
	 * @throws ClientProtocolException 
	 */
	public static void main(String args[]) throws ClientProtocolException, ParserException, IOException {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(PatentFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(PatentFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(PatentFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PatentFrame.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PatentFrame().setVisible(true);
			}
		});
		
//		PatentFrame frame=new PatentFrame();
//		frame.setVisible(true);
	}

}
