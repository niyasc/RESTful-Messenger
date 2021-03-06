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
import javax.ws.rs.core.MediaType;

import messenger.models.Profile;
import messenger.service.ProfileService;

@Path("/profiles")
public class ProfileResource
{
	private ProfileService profileService;

	public ProfileResource()
	{
		profileService = new ProfileService();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles()
	{
		return profileService.getProfiles();
	}

	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String profileName)
	{
		return profileService.getProfile(profileName);
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile Profile)
	{
		return profileService.addProfile(Profile);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Profile updateProfile(Profile Profile)
	{
		return profileService.updateProfile(Profile);
	}

	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile removeProfile(@PathParam("profileName") String profileName)
	{
		return profileService.removeProfile(profileName);
	}
}
