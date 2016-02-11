package messenger.service;

import java.util.ArrayList;
import java.util.List;

import messenger.models.Message;

public class MessageService
{
	public List<Message> getMessages()
	{
		List<Message> messages = new ArrayList<>();

		Message m1 = new Message(1, "Hello World", "Niyas C");
		Message m2 = new Message(2, "Hello, Globe", "Nisam C");

		messages.add(m1);
		messages.add(m2);

		return messages;
	}
}
