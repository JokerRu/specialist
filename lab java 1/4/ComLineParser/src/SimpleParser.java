public class SimpleParser extends ComLineParser{

    public SimpleParser(String[] keys) {
        super(keys);
    }
    public SimpleParser(String[] keys, String[] delimeters) {
        super(keys, delimeters);
    }

    private String inFile;
    private String outFile;

    public String getInFile() {
        return inFile;
    }
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void OnUsage(String errorKey){
        if (errorKey != null)
            System.out.println("Command-line switch error:" + errorKey);
        System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
        System.out.println("   -?  показать Help файл");
        System.out.println("   -r  задать имя входного файла");
        System.out.println("   -w  выполнить вывод в указанный файл");
    }

    @Override
    public SwitchStatus OnSwitch(String key, String keyValue) {
        SwitchStatus status = SwitchStatus.NoError;
        switch (key){
            case "-?":
                status = SwitchStatus.ShowUsage;
            case "-r":
                if (keyValue.length() != 0) {
                    inFile=keyValue;
                }
                else{
                    //OnUsage("empty value");
                    status = SwitchStatus.Error;
                }
            case "-w":
                if (keyValue.length() != 0) {
                    outFile=keyValue;
                }
                else{
                    //OnUsage("empty value");
                    status = SwitchStatus.Error;
                }
        }
        System.out.println("key: " + key + "; keyValue: " + keyValue);
        return status;
    }
}