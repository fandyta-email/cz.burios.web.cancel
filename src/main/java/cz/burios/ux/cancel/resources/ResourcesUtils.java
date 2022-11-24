package cz.burios.ux.cancel.resources;

import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.*;

import cz.burios.ux.cancel.exceptions.WebAppException;

public class ResourcesUtils {
	
	private static Logger _logger = LogManager.getLogger(ResourcesUtils.class);

	public static String getResourceAsText(String resourcePath) {
		String retVal = null;

		InputStream in = ResourcesUtils.class.getResourceAsStream(resourcePath);
		StringWriter writer = new StringWriter();
		try {
			IOUtils.copy(in, writer, "UTF-8");
			retVal = writer.toString();
		} catch (Exception e) {
			String errorMsg = String.format("Detected error: %s", e.getMessage());
			_logger.error(errorMsg);
			throw new WebAppException(String.format("Detected error: %s", e.getMessage()), e);
		} finally {
			try {
				writer.close();
				in.close();
			} catch (Exception e) {
				_logger.warn("Exception occurred when attempt to close the streams, will ignore this.");
			}
		}

		return retVal;
	}
}
