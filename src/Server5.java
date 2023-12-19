
import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Server5 extends javax.swing.JFrame {

    ServerSocket server; ////this object is responsible for listening to incoming connections or clients and creating a socket object to communicate with them. 
    Socket socket;
    ObjectInputStream input;
    ObjectOutputStream output;
    BigInteger encryptedmsg;
   
    String security=null;
    String secure=null; 
    private BigInteger privateKey;  
    private BigInteger publicKey;
    private BigInteger n;
    private SecureRandom random;
    Data dat = null;
    
    public Server5() {
        
        super("SERVER");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50,50,1200,900);
        this.setResizable(false); 
        this.setBackground(Color.CYAN);
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
        ServerStatusArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ServerChatArea = new javax.swing.JTextArea();
        ServerTextfield = new javax.swing.JTextField();
        ServerSendButton = new javax.swing.JButton();
        ServerReadButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        ServerStatusArea.setBackground(new java.awt.Color(51, 0, 51));
        ServerStatusArea.setColumns(20);
        ServerStatusArea.setForeground(new java.awt.Color(204, 204, 255));
        ServerStatusArea.setRows(5);
        jScrollPane1.setViewportView(ServerStatusArea);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STATUS :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CHAT WINDOW :");

        ServerChatArea.setBackground(new java.awt.Color(51, 0, 51));
        ServerChatArea.setColumns(20);
        ServerChatArea.setForeground(new java.awt.Color(255, 255, 255));
        ServerChatArea.setRows(5);
        jScrollPane2.setViewportView(ServerChatArea);

        ServerTextfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerTextfieldActionPerformed(evt);
            }
        });

        ServerSendButton.setText("SEND");
        ServerSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerSendButtonActionPerformed(evt);
            }
        });

        ServerReadButton.setText("DECRYPT");
        ServerReadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServerReadButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(ServerSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(ServerReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addComponent(ServerTextfield))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(ServerTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ServerSendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ServerReadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ServerReadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerReadButtonActionPerformed
  
        try{
            String pane=JOptionPane.showInputDialog(this,"Hey Client please provide the OTP you just recieved!");
            if(!pane.equals(secure)){
                JOptionPane.showMessageDialog(this,"Incorrect OTP !!");
                ServerSendButton.setEnabled(false);
                ServerReadButton.setEnabled(false);
            }
            else{
                JOptionPane.showMessageDialog(this,"Correct OTP !!");
                String value = decrypt(dat.key, dat.n, dat.msg);
                ServerChatArea.append("\t\t\t(Decrypted) CLIENT : " + value);
            }
        }
        catch(Exception e){}
    }//GEN-LAST:event_ServerReadButtonActionPerformed

    private void ServerTextfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerTextfieldActionPerformed

        sendMessage(ServerTextfield.getText());
        ServerTextfield.setText("");
    }//GEN-LAST:event_ServerTextfieldActionPerformed

    private void ServerSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServerSendButtonActionPerformed
      sendMessage(ServerTextfield.getText());
      ServerTextfield.setText("");
    }//GEN-LAST:event_ServerSendButtonActionPerformed

    
    public void connect(){
        ServerChatArea.setEditable(false);
        ServerStatusArea.setEditable(false);
        try{
            server=new ServerSocket(7777,100);
            while(true){
                try{
                    ServerStatusArea.append(" Server Is Ready To Accept Connection . . .\n");
                    ServerStatusArea.append(" Waiting......\n"); 
                    socket=server.accept();
                    ServerStatusArea.append(" Connected to 127.0.0.1 !!!! \n"); 
                    
                    output = new ObjectOutputStream(socket.getOutputStream());
                    output.flush();
                    input = new ObjectInputStream(socket.getInputStream());
                    chatting();
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }    
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void send(Object message){
        if(message==null){
            return;
        }
        try{
            if(message instanceof String){
                output.writeObject(message);
                output.flush();
            }
        }
        catch(Exception e){
            ServerStatusArea.append("\n Error : Cannot send message!, PLEASE RETRY");
        } 
    }
    
    public void chatting() throws IOException{
        Data message = null;
        ServerTextfield.setEditable(true);
        double dd;
        double mm;
        while((dd=Math.random())<0.1){}
        Integer xx=(int)(dd*100000);
        String s=xx.toString();
        security=s;
	String mess = " You are now connected!\n Your OTP : "+s;
        send(mess);
        while((mm=Math.random())<0.1){}
        Integer yy=(int)(mm*100000);
        String str=yy.toString();
        secure=str;
        String content=" You are now connected to the client!\n Your OTP : "+str;
        ServerStatusArea.append(content);
        
        try{
            String ss=(String)input.readObject();
                if(!ss.equals(security)){
                    send("Incorrect OTP !");
                    ServerSendButton.setEnabled(false);
                    return;
                }
                else{
                    send(" Verification Successfull !");
                }
        }
        catch(Exception e){
            System.out.println(e);
        }
        do{
            try{
                dat=(Data)input.readObject();
                String value = decrypt(dat.key, dat.n, dat.msg);
                ServerChatArea.append("\n\n\t\t\t(Encrypted) CLIENT : " + dat.msg.toString() + "\n");         
            }
            catch(Exception e){}
        }
        while(!dat.equals(0));
    }
    
    private void sendMessage(String message){
        try{
            ServerChatArea.append("\n(ME) SERVER : "+message);
            generateKeys(1024);
            encryptedmsg = encrypt(publicKey, n, message);
            ServerReadButton.setEnabled(true);
            Data data = new Data(encryptedmsg, privateKey, n);
            output.writeObject(data);
            output.flush();
        }
        catch(Exception e){
            ServerChatArea.append("\n Unable to the message");
        }
    }
    
    public static void main(String args[]) {
        Server5 server =new Server5();
        server.connect();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea ServerChatArea;
    private javax.swing.JButton ServerReadButton;
    private javax.swing.JButton ServerSendButton;
    private javax.swing.JTextArea ServerStatusArea;
    private javax.swing.JTextField ServerTextfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

