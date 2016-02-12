package messenger.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlTransient;

public class Message
{
	private long id;
	private String message;
	private Date createdOn;
	private String author;
	private List<Link> links = new ArrayList<>();
	private Map<Long, Comment> comments = new HashMap<>();

	public Message()
	{
	}

	public Message(long id, String message, Date createdOn, String createdBy)
	{
		this.id = id;
		this.message = message;
		this.author = createdBy;
		this.createdOn = createdOn;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public Date getCreatedOn()
	{
		return createdOn;
	}

	public void setCreatedOn(Date createdOn)
	{
		this.createdOn = createdOn;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public List<Link> getLinks()
	{
		return links;
	}

	public void setLinks(List<Link> links)
	{
		this.links = links;
	}

	@XmlTransient
	public Map<Long, Comment> getComments()
	{
		return comments;
	}

	public void setComments(Map<Long, Comment> comments)
	{
		this.comments = comments;
	}

	@Override
	public String toString()
	{
		return "Message [id=" + id + ", message=" + message + ", createdOn="
				+ createdOn + ", createdBy=" + author + "]";
	}

	public void addLink(String rel, String url)
	{
		Link link = new Link();
		link.setRel(rel);
		link.setUrl(url);
		links.add(link);
	}

	public Comment addComment(Comment comment)
	{
		long commentId = comment.getId();
		return comments.put(commentId, comment);
	}

	public Comment removeComment(long commentId)
	{
		return comments.remove(commentId);
	}

	public Comment updateComment(Comment comment)
	{
		long commentId = comment.getId();
		if (!comments.containsKey(commentId)) return null;
		return comments.remove(commentId);
	}
}
