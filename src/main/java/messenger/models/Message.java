package messenger.models;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


public class Message
{
	private long id;
	private String message;
	private Date createdOn;
	private String createdBy;

	public Message()
	{
	}

	public Message(long id, String message/* , Date createdOn */, String createdBy)
	{
		this.id = id;
		this.message = message;
		this.createdBy = createdBy;
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

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

}
