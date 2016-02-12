package messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import messenger.models.Message;
import messenger.service.MessageService;

@Path("/messages")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MessageResource
{
	private MessageService messageService;

	public MessageResource()
	{
		messageService = new MessageService();
	}

	@GET
	public List<Message> getMessages(@QueryParam("year") int year,
			@QueryParam("start") int start, @QueryParam("size") int size)
	{
		List<Message> messages;
		if (year != 0)
			messages = messageService.getMessagesForYear(year);
		else if (size != 0 && start != 0)
			messages = messageService.getMessagesPaginated(start, size);
		else
			messages = messageService.getMessages();

		return messages;
	}

	@GET
	@Path("/{id}")
	public Message getMessage(@PathParam("id") long id,
			@Context UriInfo uriInfo)
	{
		Message message = messageService.getMessage(id);
		message.addLink("self", getUriForSelf(message, uriInfo));
		message.addLink("profile", getUriForProfile(message, uriInfo));
		message.addLink("comments", getUriForComments(message, uriInfo));
		return message;
	}

	@POST
	public Message addMessage(Message message)
	{
		return messageService.addMessage(message);
	}

	@PUT
	public Message updateMessage(Message message)
	{
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public Message removeMessage(@PathParam("messageId") long messageId)
	{
		return messageService.removeMessage(messageId);
	}

	private String getUriForSelf(Message message, UriInfo uriInfo)
	{
		long id = message.getId();
		return uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(Long.toString(id)).build().toString();
	}

	private String getUriForProfile(Message message, UriInfo uriInfo)
	{
		URI uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class)
				.path(message.getAuthor()).build();
		return uri.toString();
	}

	private String getUriForComments(Message message, UriInfo uriInfo)
	{
		URI uri = uriInfo.getBaseUriBuilder().path(MessageResource.class)
				.path(MessageResource.class, "getCommentResource")
				.path(CommentResource.class)
				.resolveTemplate("messageId", message.getId())
				.build();
		return uri.toString();
	}

	@Path("/{messageId}/comments")
	public CommentResource getCommentResource()
	{
		return new CommentResource();
	}
}
