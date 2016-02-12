package messenger.models;

import java.util.Date;

public class Comment
{
	private long id;
	private String comment;
	private Date createdOn;
	private String author;

	public Comment()
	{
	}

	public Comment(long id, String comment, Date createdOn, String author)
	{
		super();
		this.id = id;
		this.comment = comment;
		this.createdOn = createdOn;
		this.author = author;
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
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

}
