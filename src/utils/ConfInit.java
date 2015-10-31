package  src.utils;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

public class ConfInit {

  private String nameFile = "";  
  private Properties p = null;   

  public ConfInit() { 
    p = new Properties();
  }

  public ConfInit(String nameFile) {
    p = new Properties();
    setNameFile(nameFile);
  }

  public String getParameters(String nombreParametro){
    return p.getProperty(nombreParametro).trim();
  }

  public void setNameFile(String nameFile) {
    try {
      this.nameFile = nameFile;
       p.load(new FileInputStream(this.nameFile));
    }
    catch (Exception ex) {
     ex.printStackTrace();
    }
  }

  public Set<Object> keySet(){
    return p.keySet();
  }

  public void listar(){
    p.list(System.out);
  }

  public static void main(String[] args) {
		ConfInit iniFile = new ConfInit();
    iniFile.setNameFile("conf.ini");
  }

}