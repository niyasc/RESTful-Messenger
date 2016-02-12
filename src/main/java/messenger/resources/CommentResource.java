package messenger.resources;

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

import messenger.models.Comment;
import messenger.service.CommentService;

@Path("/")
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Consumes(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class CommentResource
{
	private CommentService commentService;

	public CommentResource()
	{
		commentService = new CommentService();
	}

	@GET
	public List<Comment> getComments(@PathParam("messageId") long messageId,
			@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size)
	{
		List<Comment> comments;
		if (year != 0)
			comments = commentService.getCommentsForYear(messageId, year);
		else if (size != 0 && start != 0)
			comments = commentService.getCommentsPaginated(messageId, start,
					size);
		else
			comments = commentService.getComments(messageId);

		return comments;
	}

	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId, @Context UriInfo uriInfo)
	{
		Comment comment = commentService.getComment(messageId, commentId);
		return comment;
	}

	@POST
	public Comment addComment(@PathParam("messageId") long messageId,
			Comment comment)
	{
		return commentService.addComment(messageId, comment);
	}

	@PUT
	public Comment updateComment(@PathParam("messageId") long messageId,
			Comment comment)
	{
		return commentService.updateComment(messageId, comment);
	}

	@DELETE
	@Path("/{commentId}")
	public Comment removeComment(@PathParam("messageId") long messageId,
			@PathParam("commentId") long commentId)
	{
		return commentService.removeComment(messageId, commentId);
	}
}
