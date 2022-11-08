public abstract class ComLineParser {

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
    public abstract void OnUsage(String errorKey);

    // вызывается для каждого найденного ключа в командной строке - КОГДА ОН ВЫЗЫВАЕТСЯ?
    public SwitchStatus OnSwitch(String key, String keyValue){
        System.out.println("key: " + key + "; keyValue: " + keyValue);
        return SwitchStatus.NoError;
    }

    public final boolean Parse(String [] args){
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