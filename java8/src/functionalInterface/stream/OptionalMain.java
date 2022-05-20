package functionalInterface.stream;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalMain {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", true));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        Optional<OnlineClass> optional2 = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean flag = optional.isPresent();
        System.out.println("spring 포함한 title 있음 = " + flag);

        OnlineClass oc = optional.get();
        System.out.println(oc.getId() + " " + oc.getTitle());

//        OnlineClass oc2 = optional2.get(); // 비어있기 때문에 RuntimeException 발생함. get의 경우 다른 api로 커버하고 최대한 사용을 지양해야함.

        if(optional.isPresent()) {
            System.out.println(optional.get().getTitle());
        }
        optional.ifPresent(p -> p.getTitle());

        OnlineClass onlineClass1 = optional.orElse(createNewClass());
        System.out.println(onlineClass1.getTitle());

        OnlineClass onlineClass2 = optional2.orElse(createNewClass());
        System.out.println(onlineClass2.getTitle());

        OnlineClass onlineClass3 = optional.orElseGet(OptionalMain::createNewClass);
        System.out.println(onlineClass3.getTitle());

        // OnlineClass onlineClass4 = optional2.orElseThrow();

        Optional<OnlineClass> onlineClass = optional.filter(OnlineClass::isClosed);
        System.out.println(onlineClass.isPresent());

        Optional<String> title = optional.map(OnlineClass::getTitle);
        System.out.println(title.get());

        Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        Progress progress2 = progress1.orElseThrow();

        Optional<Progress> progress3 = optional.flatMap(OnlineClass::getProgress);

    }

    private static OnlineClass createNewClass() {
        System.out.println("createing new class");
        return new OnlineClass(10, "new class", false);
    }
}