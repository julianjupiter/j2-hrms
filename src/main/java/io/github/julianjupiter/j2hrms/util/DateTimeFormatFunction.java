package io.github.julianjupiter.j2hrms.util;

import org.jtwig.functions.FunctionRequest;
import org.jtwig.functions.SimpleJtwigFunction;

public class DateTimeFormatFunction extends SimpleJtwigFunction {

    public DateTimeFormatFunction() {
    }

    @Override
    public String name() {
        return "datetime_format";
    }

    @Override
    public Object execute(FunctionRequest request) {
        request.minimumNumberOfArguments(1).maximumNumberOfArguments(1);
        String input = request.getEnvironment().getValueEnvironment().getStringConverter().convert(request.get(0));
        return input.toUpperCase();
    }
}
