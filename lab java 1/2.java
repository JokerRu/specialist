public class Main {

    public static void main(String[] args) {
	// Разбор параметров командной строки 
    }
        public static class ComLineParser {

        // массив строк для хранения ключей
        String [] keys;
        // массив строк для хранения разделителей
        String [] delimeters;
        // варианты завершения разбора командной строки
        public enum SwitchStatus { NoError, Error, ShowUsage };

        public ComLineParser(String[] keys, String[] delimeters) {
            this.keys = keys;
            this.delimeters = delimeters;
        }

        public ComLineParser(String[] keys) {
            this(keys, new String[]{"/","-"});
        }

        // выводит подсказку с форматом командной строки в случае ошибки
        public void OnUsage(String errorKey){
            if (errorKey != null) System.out.println(errorKey);
            System.out.println("формат ком.строки: имяПрограммы [-r<input-fileName>] [-w<output-fileName>]");
            System.out.println("   -?  показать Help файл");
            System.out.println("   -r  задать имя входного файла");
            System.out.println("   -w  выполнить вывод в указанный файл");
        }

        // вызывается для каждого найденного ключа в командной строке - КОГДА ОН ВЫЗЫВАЕТСЯ?
        public SwitchStatus OnSwitch(String key, String keyValue){
            System.out.println("key: " + key + "; keyValue: " + keyValue);
            return SwitchStatus.NoError;
        }

        public boolean Parse(String [] args){
            SwitchStatus ss = SwitchStatus.NoError;
            int argNum;
            for (argNum = 0; (ss == SwitchStatus.NoError) && (argNum < args.length); argNum++) {
                // провера наличия правильного разделителя
                boolean isDelimeter = false;
                for (int n = 0; !isDelimeter && (n < delimeters.length); n++) {
                    isDelimeter = args[argNum].regionMatches(0,delimeters[n], 0, 1);
                }
                if (isDelimeter) {
                    // проверка наличия правильного ключа после правильного разделителя
                    boolean isKey = false;
                    int i;
                    for (i = 0; !isKey && (i < keys.length); i++) {
                        isKey = args[argNum].toUpperCase().regionMatches(1, keys[i].toUpperCase(), 0, 1);
                        if (isKey) {
                            // ИСПРАВИТЬ
                            ss = OnSwitch(args[argNum].substring(0, 2),args[argNum].substring(2));
                            break;
                        }
                    }
                    if (!isKey) ss = SwitchStatus.Error;
                }
                else {
                    ss=SwitchStatus.Error;
                    break;
                }
            }
            if (ss == SwitchStatus.ShowUsage)    OnUsage(null);
            if (ss == SwitchStatus.Error)        OnUsage((argNum == args.length) ? null : args[argNum]);
            return true;
        }

    }

    public class LabRab2 {

        public static void main(String[] args) {
            ComLineParser pars = new ComLineParser(new String[] {"?","r","w" });
            pars.Parse(args);
        }
    }

}
