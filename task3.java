// Java program for checking
// balanced brackets
import java.util.*;

public class task3 {

	// функция для проверки сбалансированности скобок
	static boolean areBracketsBalanced(String expr)
	{
		// Использование ArrayDeque выполняется быстрее, чем использование класса Stack
		Deque<Character> stack
			= new ArrayDeque<Character>();

		// Обход выражения
		for (int i = 0; i < expr.length(); i++)
		{
			char x = expr.charAt(i);

			if (x == '(' || x == '[' || x == '{')
			{
				// добавим элемент в стек
				stack.push(x);
				continue;
			}

			// Если текущий символ не открывается
            // скобка, тогда она должна быть закрывающей. Так что складывайте
            // не может быть пустым на данный момент.
			if (stack.isEmpty())
				return false;
			char check;
			switch (x) {
			case ')':
				check = stack.pop();
				if (check == '{' || check == '[')
					return false;
				break;

			case '}':
				check = stack.pop();
				if (check == '(' || check == '[')
					return false;
				break;

			case ']':
				check = stack.pop();
				if (check == '(' || check == '{')
					return false;
				break;
			}
		}

		// Проверьте пустой стек
		return (stack.isEmpty());
	}

	// Код драйвера
	public static void main(String[] args)
	{
		String expr = "([{}])";

		// Вызов функции
		if (areBracketsBalanced(expr))
			System.out.println("Все правильно");
		else
			System.out.println("Не правильно ");
	}
}
