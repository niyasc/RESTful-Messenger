package messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import messenger.dummydb.DummyDB;
import messenger.models.Comment;
import messenger.models.Message;

public class MessageService
{
	private Map<Long, Message> messages = DummyDB.getMessages();

	public MessageService()
	{
		Message m1 = new Message(1, "Hello, Java", new Date(), "Niyas C");
		Message m2 = new Message(2, "Hello, Arabic", new Date(), "Nisam C");
		Message m3 = new Message(3, "Hello, World", new Date(), "Niyas C");

		messages.put((long) 1, m1);
		messages.put((long) 2, m2);
		messages.put((long) 3, m3);

		Comment c1 = new Comment(1, "Comment 1", new Date(), "Niyas C");
		Comment c2 = new Comment(2, "Comment 2", new Date(), "Nisam C");
		Comment c3 = new Comment(3, "Comment 3", new Date(), "Niyas C");
		Comment c4 = new Comment(4, "Comment 4", new Date(), "Nisam C");

		m1.addComment(c1);
		m1.addComment(c2);
		m1.addComment(c3);
		m2.addComment(c4);

	}

	public List<Message> getMessages()
	{
		return new ArrayList<>(messages.values());
	}

	public Message getMessage(long id)
	{
		return messages.get(id);
	}

	public Message addMessage(Message message)
	{
		long id = messages.size() + 1;
		message.setId(id);
		message.setCreatedOn(new Date());
		messages.put(id, message);
		return message;
	}

	public Message removeMessage(long id)
	{
		Message message = messages.get(id);
		messages.remove(id);
		return message;
	}

	public Message updateMessage(Message message)
	{
		long id = message.getId();
		if (id == 0) return null;

		messages.put(id, message);

		return message;

	}

	public List<Message> getMessagesForYear(int year)
	{
		List<Message> messageList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();

		for (Message message : messages.values())
		{
			cal.setTime(message.getCreatedOn());
			if (cal.get(Calendar.YEAR) == year)
			{
				messageList.add(message);
			}
		}
		return messageList;
	}

	public List<Message> getMessagesPaginated(int start, int size)
	{
		List<Message> messageList = new ArrayList<Message>(messages.values());
		return messageList.subList(start, start + size);
	}

}
