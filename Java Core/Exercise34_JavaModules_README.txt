This exercise requires two modules:

Directory structure:
project-root/
├── com.greetings/
│   ├── module-info.java
│   └── com/greetings/Main.java
└── com.utils/
    ├── module-info.java
    └── com/utils/Utils.java

-- com.utils/module-info.java --
module com.utils {
    exports com.utils;
}

-- com.utils/com/utils/Utils.java --
package com.utils;
public class Utils {
    public static String greet(String name) {
        return "Hello, " + name + "!";
    }
}

-- com.greetings/module-info.java --
module com.greetings {
    requires com.utils;
}

-- com.greetings/com/greetings/Main.java --
package com.greetings;
import com.utils.Utils;
public class Main {
    public static void main(String[] args) {
        System.out.println(Utils.greet("Java"));
    }
}