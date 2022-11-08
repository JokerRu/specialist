public class SimpleParser extends ComLineParserBase {
    private String inFile;
    private String outFile;

    public String getInFile()  { return inFile; }
    public String getOutFile() { return outFile; }

    public SimpleParser(){
        super(new String[]{"?","r","w"});
    }
    @Override
    protected void OnUsage(String errorKey){
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);

        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }
    @Override
    protected SwitchStatus OnSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;

        switch (key) {
            case "?":  status = SwitchStatus.ShowUsage; break;
            case "r":
                if (keyValue.length() < 1) {
                    System.out.println("Нет имени входного файла.");
                    status = SwitchStatus.Error;
                }
                else  inFile = keyValue;
                break;
            case "w":
                if (keyValue.length() < 1) {
                    System.out.println("Нет имени выходного файла.");
                    status = SwitchStatus.Error;
                }
                else  outFile = keyValue;
                break;
            default:  status = SwitchStatus.Error; break;
        }
        return status;
    }
}