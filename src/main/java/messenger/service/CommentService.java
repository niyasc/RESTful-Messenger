package messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import messenger.dummydb.DummyDB;
import messenger.models.Comment;
import messenger.models.Message;

public class CommentService
{
	private Map<Long, Message> messages = DummyDB.getMessages();

	public List<Comment> getComments(long messageId)
	{
		Message message = messages.get(messageId);
		if (message == null) return null;
		return new ArrayList<Comment>(message.getComments().values());
	}

	public Comment getComment(long messageId, long commentId)
	{
		Message message = messages.get(messageId);
		if (message == null) return null;
		Map<Long, Comment> comments = message.getComments();
		return comments.get(commentId);
	}

	public Comment addComment(long messageId, Comment comment)
	{
		Message message = messages.get(messageId);
		if (message == null) return null;
		long id = message.getComments().size() + 1;
		comment.setId(id);
		comment.setCreatedOn(new Date());
		message.addComment(comment);
		return comment;
	}

	public Comment removeComment(long messageId, long commentId)
	{
		Message message = messages.get(messageId);
		return message.removeComment(commentId);
	}

	public Comment updateComment(long messageId, Comment comment)
	{
		Message message = messages.get(messageId);
		if (message == null) return null;
		return message.updateComment(comment);
	}

	public List<Comment> getCommentsForYear(long messageId, int year)
	{
		Message message = messages.get(messageId);
		if (message == null) return null;
		List<Comment> commentList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		Set<Comment> comments = (Set<Comment>) message.getComments().values();
		for (Comment comment : comments)
		{
			cal.setTime(comment.getCreatedOn());
			if (cal.get(Calendar.YEAR) == year)
			{
				commentList.add(comment);
			}
		}
		return commentList;
	}

	public List<Comment> getCommentsPaginated(long messageId, int start,
			int size)
	{
		Message message = messages.get(messageId);
		List<Comment> commentList = new ArrayList<Comment>(
				message.getComments().values());
		return commentList.subList(start, start + size);
	}

}
