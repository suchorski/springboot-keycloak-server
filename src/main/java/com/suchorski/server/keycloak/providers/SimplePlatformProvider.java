package com.suchorski.server.keycloak.providers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.keycloak.Config.Scope;
import org.keycloak.common.Profile;
import org.keycloak.common.profile.PropertiesFileProfileConfigResolver;
import org.keycloak.common.profile.PropertiesProfileConfigResolver;
import org.keycloak.platform.PlatformProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimplePlatformProvider implements PlatformProvider {

	private File tmpDir;

	public SimplePlatformProvider() {
		Profile.configure(
				new PropertiesProfileConfigResolver(System.getProperties()),
				new PropertiesFileProfileConfigResolver());
	}

	@Override
	public String name() {
		return "springboot-keycloak-server";
	}

	@Override
	public void onStartup(Runnable startupHook) {
		startupHook.run();
	}

	@Override
	public void onShutdown(Runnable shutdownHook) {
	}

	@Override
	public void exit(Throwable cause) {
		throw new RuntimeException(cause);
	}

	@Override
	public File getTmpDirectory() {
		if (tmpDir == null) {
			final var projectBuildDir = System.getProperty("project.build.directory");
			File tmpDir;
			if (projectBuildDir != null) {
				tmpDir = new File(projectBuildDir, "server-tmp");
				tmpDir.mkdir();
			} else {
				try {
					tmpDir = Files.createTempDirectory("keycloak-server-").toFile();
					tmpDir.deleteOnExit();
				} catch (IOException ioe) {
					throw new RuntimeException("Could not create temporary directory", ioe);
				}
			}
			if (tmpDir.isDirectory()) {
				this.tmpDir = tmpDir;
				log.info("Using server tmp directory: {}", tmpDir.getAbsolutePath());
			} else {
				throw new RuntimeException("Directory " + tmpDir + " was not created and does not exists");
			}
		}
		return tmpDir;
	}

	@Override
	public ClassLoader getScriptEngineClassLoader(Scope scriptProviderConfig) {
		return null;
	}

}