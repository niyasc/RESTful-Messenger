package messenger.dummydb;

import java.util.HashMap;
import java.util.Map;

import messenger.models.Message;
import messenger.models.Profile;

/**
 * Mimic database until a real database is created. This implementation is not
 * thread safe
 */
public class DummyDB
{
	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	public static Map<Long, Message> getMessages()
	{
		return messages;
	}

	public static Map<String, Profile> getProfiles()
	{
		return profiles;
	}

}
