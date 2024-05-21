package Checker;

/**
 * A classe DateChecker é responsável pela verificação e formatação de datas no formato SQL.
 * As datas são formatadas como "ano-mês-dia".
 * 
 * @author SYNC
 */
public class DateChecker {

    protected String Separator = "-"; // Separador utilizado para formatar a data no formato SQL
    public String Date = null;  // Variável que armazena a data formatada
    protected String daySTR = null; // Variável que armazena o dia como String
    protected String monthSTR = null; // Variável que armazena o mês como String
    protected String yearSTR = null; // Variável que armazena o ano como String

    /**
     * Constrói uma data no formato "ano-mês-dia" a partir dos valores de dia, mês e ano f0ornecidos.w
     * @param day O dia do mês (inteiro)
     * @param month O mês do ano (inteiro, de 0 a 11, onde 0 representa Janeiro e 11 representa Dezembro)
     * @param year O ano (inteiro)
     * @return A data formatada como uma String no formato "ano-mês-dia"
     */
    public String Checker(int day, int month, int year) {
        Date = null;
        daySTR = Integer.toString(day);
        monthSTR = null;

        // Mapeamento dos meses do ano para strings de dois dígitos
        switch (month) {
            case 0:
                monthSTR = "01"; // Janeiro
                break;
            case 1:
                monthSTR = "02"; // Fevereiro
                break;
            case 2:
                monthSTR = "03"; // Março
                break;
            case 3:
                monthSTR = "04"; // Abril
                break;
            case 4:
                monthSTR = "05"; // Maio
                break;
            case 5:
                monthSTR = "06"; // Junho
                break;
            case 6:
                monthSTR = "07"; // Julho
                break;
            case 7:
                monthSTR = "08"; // Agosto
                break;
            case 8:
                monthSTR = "09"; // Setembro
                break;
            case 9:
                monthSTR = "10"; // Outubro
                break;
            case 10:
                monthSTR = "11"; // Novembro
                break;
            case 11:
                monthSTR = "12"; // Dezembro
                break;
        }
        
        yearSTR = Integer.toString(year);
        return Date = yearSTR + Separator + monthSTR + Separator + daySTR;
    }
    
    public String Day;
    public String Month;
    public String Year;
            
    public void FormateDate(String date) {
        String[] partes = date.split("-");
        Day = partes[2];
        Month = partes[1];
        Year = partes[0];
        
        
        System.out.println("Log: " + " Dia: " +Day+ " Mes: " +Month+ " Ano: " +Year);
    }

}
