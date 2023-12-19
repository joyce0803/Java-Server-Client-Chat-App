
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Client5 extends javax.swing.JFrame {
    Socket socket;
    ObjectInputStream input;
    ObjectOutputStream output;
    String message ="";
    String content;
    BigInteger encryptedmsg;
    String security=null;
    String secure=null;
    private BigInteger privateKey;  
    private BigInteger publicKey;
    private BigInteger n;
    private SecureRandom random;
    Data dat = null;
    
    
    public Client5() {
        super("CLIENT");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(650,50,1200,900);
        this.setResizable(false);
        initComponents();
        this.random=new SecureRandom();
    }
    
     public void generateKeys(int keyDigits){

        BigInteger p=BigInteger.probablePrime(keyDigits, random);
        BigInteger q=BigInteger.probablePrime(keyDigits, random);
        n=p.multiply(q);
        BigInteger phi=(p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        BigInteger e=generatePublicFactor(phi);
        BigInteger d=e.modInverse(phi);
        
        this.privateKey=d;
        this.publicKey=e;
    }
    
    public BigInteger generatePublicFactor(BigInteger phi){

        BigInteger e=new BigInteger(phi.bitLength(),random);
        while(!e.gcd(phi).equals(BigInteger.ONE)){
            e=new BigInteger(phi.bitLength(),random);
        }
        return e;
    }
    
    private BigInteger encrypt(BigInteger e, BigInteger n, String message){

        byte[] messageToByte= message.getBytes();
        BigInteger messageToInt=new BigInteger(messageToByte);
        return messageToInt.modPow(e, n);
    }

   public String decrypt(BigInteger d, BigInteger n, BigInteger cipherText){

        BigInteger messageInt=cipherText.modPow(d,n);
        return new String(messageInt.toByteArray());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ClientStatusArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ClientChatArea = new javax.swing.JTextArea();
        ClientTextfield = new javax.swing.JTextField();
        ClientSendButton = new javax.swing.JButton();
        ClientReadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        ClientStatusArea.setBackground(new java.awt.Color(51, 0, 0));
        ClientStatusArea.setColumns(20);
        ClientStatusArea.setForeground(new java.awt.Color(204, 204, 255));
        ClientStatusArea.setRows(5);
        jScrollPane1.setViewportView(ClientStatusArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STATUS :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CHAT WINDOW :");

        ClientChatArea.setBackground(new java.awt.Color(51, 0, 51));
        ClientChatArea.setColumns(20);
        ClientChatArea.setForeground(new java.awt.Color(255, 255, 255));
        ClientChatArea.setRows(5);
        jScrollPane2.setViewportView(ClientChatArea);

        ClientTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientTextfieldActionPerformed(evt);
            }
        });

        ClientSendButton.setText("SEND");
        ClientSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientSendButtonActionPerformed(evt);
            }
        });

        ClientReadButton.setText("DECRYPT");
        ClientReadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientReadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ClientTextfield)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(ClientSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                .addComponent(ClientReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addComponent(jScrollPane2))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ClientTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClientSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClientReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClientTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientTextfieldActionPerformed
        sendMessage(ClientTextfield.getText());
        ClientTextfield.setText("");
    }//GEN-LAST:event_ClientTextfieldActionPerformed

    private void ClientSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientSendButtonActionPerformed

        sendMessage(ClientTextfield.getText());
        ClientTextfield.setText("");
    }//GEN-LAST:event_ClientSendButtonActionPerformed

    private void ClientReadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientReadButtonActionPerformed
       
        try{
            String rs=JOptionPane.showInputDialog(this,"Hey Client please provide the OTP you just recieved!");
            
            if(!rs.equals(security)){
                JOptionPane.showMessageDialog(this," Incorrect OTP !!");
                ClientSendButton.setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(this," Correct OTP !!"); 
                String value = decrypt(dat.key, dat.n, dat.msg);
                
                ClientChatArea.append("\t\t\t(Decrypted) SERVER: " + value);
            }
        }
        catch(Exception e){}   
    }//GEN-LAST:event_ClientReadButtonActionPerformed

    public void connect(){
        try{
            ClientReadButton.setEnabled(false);
            ClientChatArea.setEditable(false);
            ClientStatusArea.setEditable(false);
            ClientStatusArea.append(" Sending Request for connection to the server. . . . .\n");
            ClientStatusArea.append(" Request Sent. . . . .\n");
            socket = new Socket("127.0.0.1", 7777);
            ClientStatusArea.append(" Connected to !!!!!" +socket.getInetAddress().getHostName()+"\n");
            
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            input = new ObjectInputStream(socket.getInputStream());
            chatting();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void send(Object message){
        
        try{
            if(message==null||message instanceof String){
                output.writeObject(message);
                output.flush();
            }
        }
        catch(Exception e){
            ClientStatusArea.append("\n Error : Cannot send message!, PLEASE RETRY");
        }
        
    }
    
    public void chatting() throws IOException{
     
        ClientReadButton.setEnabled(true);
        ClientTextfield.setEditable(true);
        Data message = null;        
        Object mess=null;
        try {
            ClientStatusArea.append("\n" + (String)input.readObject());
            security=JOptionPane.showInputDialog(this,"Hey Client please provide the OTP you just recieved!");
            if(security==null){
                ClientSendButton.setEnabled(false);
                security="-";
            }
            send(security);
            String rs=(String)input.readObject();
            ClientStatusArea.append("\n" + ((rs.equals("CLOSE"))?"":rs));
        }
        catch(Exception e){}
        do{
            try{
                dat=(Data) input.readObject();
                String value = decrypt(dat.key, dat.n, dat.msg);
                ClientChatArea.append("\n\t\t\t(Encrypted) SERVER : " + dat.msg.toString() + "\n");
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        while(!dat.equals(0));
    }
    
    public BigInteger sendMessage(String message){
        try{
            ClientChatArea.append("\n\n(ME) CLIENT : " +message);
            generateKeys(1024);
            encryptedmsg = encrypt(publicKey, n, message);
            ClientReadButton.setEnabled(true);
            Data data = new Data(encryptedmsg, privateKey, n);
            output.writeObject(data);
            output.flush();
    
        }
        catch(Exception e){
            System.out.println(e);
            ClientChatArea.append("\nUnable to send message");
        }
        return encryptedmsg;
    }
    
    public static void main(String args[]) {
       
        Client5 client=new Client5();
        client.connect();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ClientChatArea;
    private javax.swing.JButton ClientReadButton;
    private javax.swing.JButton ClientSendButton;
    private javax.swing.JTextArea ClientStatusArea;
    private javax.swing.JTextField ClientTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
