package main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import main.log.Log;
import main.security.NameCollisionException;
import main.security.NoSuchConfigException;
import main.security.NoSuchKeyException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

public class Config {
	
	private HashMap<String, HashMap<String, Object>> configs;
	
	private XStream xstream = new XStream(new StaxDriver());
	
	private File cfgfile = new File("config.cfg");
	
	public Config() {
		configs = new HashMap<String, HashMap<String, Object>>();
	}
	
	public void registerConfiguration(String name, HashMap<String, Object> config)
			throws NameCollisionException {
		if (!configs.containsKey(name)) {
			configs.put(name, config);
		} else {
			throw new NameCollisionException(name);
		}
	}
	
	public Object getEntry(String module, String key) throws NoSuchConfigException, NoSuchKeyException {
		if (configs.containsKey(module)) {
			if (configs.get(module).containsKey(key)) {
				return configs.get(module).get(key);
			} else {
				throw new NoSuchKeyException(module, key);
			}
		} else {
			throw new NoSuchConfigException(module);
		}
	}
	
	public void setEntry(String module, String key, Object value) throws NoSuchKeyException, NoSuchConfigException {
		if (configs.containsKey(module)) {
			if (configs.get(module).containsKey(key)) {
				configs.get(module).put(key, value);
			} else {
				throw new NoSuchKeyException(module, key);
			}
		} else {
			throw new NoSuchConfigException(module);
		}
	}
	
	public void setDefault(String module, String key, Object value) {
		if (!configs.get(module).containsKey(key)) {
			configs.get(module).put(key, value);
		}
	}
	
	public void save() {
		Log.debug("Saving configuration...");
		try {
			if (!cfgfile.exists()) {
				cfgfile.createNewFile();
			}
			xstream.toXML(configs, new FileOutputStream(cfgfile));
			Log.debug("Configuration was saved sucessfully.");
		} catch (IOException  e) {
			e.printStackTrace(Log.cs);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void load() {
		Log.info("Loading configuration...");
		configs = (HashMap<String, HashMap<String, Object>>) xstream.fromXML(cfgfile);
		Log.info("Configuration loaded sucessfully.");
	}
	
}
