package messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import messenger.dummydb.DummyDB;
import messenger.models.Profile;

public class ProfileService
{
	private Map<String, Profile> profiles = DummyDB.getProfiles();

	public ProfileService()
	{
		Profile p1 = new Profile(1, "niyasc", "Niyas", "C", new Date());
		Profile p2 = new Profile(2, "nisamc" , "Nisam", "C", new Date());
		profiles.put(p1.getProfileName(), p1);
		profiles.put(p2.getProfileName(), p2);
	}

	public List<Profile> getProfiles()
	{
		return new ArrayList<>(profiles.values());
	}

	public Profile getProfile(String profileName)
	{
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile)
	{
		long id = profiles.size() + 1;
		profile.setId(id);
		String profileName = profile.getProfileName();
		profile.setCreatedOn(new Date());
		profiles.put(profileName, profile);
		return profile;
	}

	public Profile removeProfile(String profileName)
	{
		Profile profile = profiles.get(profileName);
		profiles.remove(profileName);
		return profile;
	}

	public Profile updateProfile(Profile profile)
	{
		String profileName = profile.getProfileName();

		
		profiles.put(profileName, profile);

		return profile;

	}
}
