
/**
 * QuanLySQLExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.0  Built on : May 17, 2011 (04:19:43 IST)
 */

package quanaoservice;

public class QuanLySQLExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1479190504648L;
    
    private quanaoservice.QuanLyStub.QuanLySQLException faultMessage;

    
        public QuanLySQLExceptionException() {
            super("QuanLySQLExceptionException");
        }

        public QuanLySQLExceptionException(java.lang.String s) {
           super(s);
        }

        public QuanLySQLExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public QuanLySQLExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(quanaoservice.QuanLyStub.QuanLySQLException msg){
       faultMessage = msg;
    }
    
    public quanaoservice.QuanLyStub.QuanLySQLException getFaultMessage(){
       return faultMessage;
    }
}
    