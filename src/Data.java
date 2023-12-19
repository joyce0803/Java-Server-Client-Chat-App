
import java.io.Serializable;
import java.math.BigInteger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Joyce Merin
 */
public class Data implements Serializable {
    BigInteger msg;
    BigInteger key;
    BigInteger n;
    
     Data(BigInteger encryptedmsg, BigInteger privateKey, BigInteger n) {
        this.msg = encryptedmsg;
        this.key = privateKey;
        this.n = n; 
    }

 

    
}
