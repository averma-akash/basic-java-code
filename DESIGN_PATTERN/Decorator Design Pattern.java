/*The decorator design pattern is used to modify the functionality of an object at runtime. At the same time, other instances of the same class will not be affected by this, so the individual object gets the modified behavior. The decorator design pattern is one of the structural design patterns (such as adapter pattern, bridge pattern, or composite pattern) and uses abstract classes or interface with the composition to implement. We use inheritance or composition to extend the behavior of an object, but this is done at compile-time, and it’s applicable to all the instances of the class. We can’t add any new functionality to remove any existing behavior at runtime – this is when the decorator pattern is useful.*/

// Component interface
interface Text {
    String format();
}

// ConcreteComponent class
class SimpleText implements Text {
    private String content;

    public SimpleText(String content) {
        this.content = content;
    }

    @Override
    public String format() {
        return content; // Base content of simple text
    }
}

// Decorator abstract class
abstract class TextDecorator implements Text {
    protected Text decoratedText;

    public TextDecorator(Text decoratedText) {
        this.decoratedText = decoratedText;
    }

    @Override
    public String format() {
        return decoratedText.format();
    }
}

// ConcreteDecorator classes
class BoldTextDecorator extends TextDecorator {
    public BoldTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String format() {
        return "<b>" + super.format() + "</b>"; // Add bold formatting
    }
}

class ItalicTextDecorator extends TextDecorator {
    public ItalicTextDecorator(Text decoratedText) {
        super(decoratedText);
    }

    @Override
    public String format() {
        return "<i>" + super.format() + "</i>"; // Add italic formatting
    }
}

// Client code
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Creating a simple text
        Text simpleText = new SimpleText("Decorator Pattern Example");

        // Adding bold formatting to the text using a decorator
        Text boldText = new BoldTextDecorator(simpleText);
        System.out.println("Formatted Text: " + boldText.format());

        // Adding italic formatting to the text using a decorator
        Text italicText = new ItalicTextDecorator(simpleText);
        System.out.println("Formatted Text: " + italicText.format());

        // Combining bold and italic formatting using multiple decorators
        Text boldItalicText = new BoldTextDecorator(new ItalicTextDecorator(simpleText));
        System.out.println("Formatted Text: " + boldItalicText.format());
    }
}


/*
In this example:

Text is the interface representing the component.
SimpleText is the concrete component class that represents simple text.
TextDecorator is the abstract decorator class that extends Text. It has a reference to the decorated text.
BoldTextDecorator and ItalicTextDecorator are concrete decorator classes that add specific formatting (bold and italic) to the text.
When you run the client code, you'll see how decorators can be used to dynamically add formatting to the base component (SimpleText). The output will display the formatted text with different combinations of decorators.
*/