import arc.*;
public class test {
  public static void main(String[] args) {
     Console con = new Console();
    
   int inta;
   double dbla = 3;
    double dblMultiplier = Math.random() * 1.5 + 1.5;
    con.println(dblMultiplier);
    dbla = Math.round(dbla*dblMultiplier);
    con.println(dbla);
    inta = (int)dbla;
    con.println(inta);
    
  }
}