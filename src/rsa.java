
import java.math.BigInteger;
import java.security.SecureRandom;

public class rsa extends javax.swing.JFrame {

    private BigInteger privateKey;  
    private BigInteger publicKey;
    private BigInteger n;
    private SecureRandom random;
   
    public rsa() {
        this.random=new SecureRandom();
        initComponents();
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

    public BigInteger encryptMessage(String message){
        return encrypt(publicKey,n,message);
    }

    public String decryptMessage(BigInteger message){
        return decrypt(privateKey,n,message);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rsa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
