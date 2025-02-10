const BASE_URL = process.env.PUBLIC_URL || "/";

export const fetchData = async (endpoint) => {
  try {
    const response = await fetch(`${BASE_URL}${endpoint}`);

    // Detect response type
    const contentType = response.headers.get("content-type");
    
    if (contentType && contentType.includes("application/json")) {
      return await response.json();
    } else {
      return await response.text();
    }

  } catch (error) {
    console.error("API Fetch Error:", error);
    throw error;
  }
};
