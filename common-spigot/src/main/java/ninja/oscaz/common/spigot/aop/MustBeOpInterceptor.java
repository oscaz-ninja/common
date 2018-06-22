package ninja.oscaz.common.spigot.aop;

import org.bukkit.permissions.ServerOperator;

import ninja.oscaz.hero.transform.intercept.Arguments;
import ninja.oscaz.hero.transform.intercept.Interceptor;
import ninja.oscaz.hero.transform.intercept.Pipe;

public class MustBeOpInterceptor implements Interceptor {

    @Override
    public Object intercept(Arguments arguments, Pipe pipe) {
        ServerOperator operator = arguments.get(ServerOperator.class);

        if (operator.isOp()) {
            return pipe.proceed();
        }

        return null;
    }

}
