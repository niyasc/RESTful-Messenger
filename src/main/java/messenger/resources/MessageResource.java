package messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import messenger.models.Message;
import messenger.service.MessageService;

@Path("/messages")
public class MessageResource
{
	private MessageService messageService;

	public MessageResource()
	{
		messageService = new MessageService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage()
	{
		return messageService.getMessages();
	}
}
