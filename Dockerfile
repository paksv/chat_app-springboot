FROM ubuntu:22.04

# Install system dependencies
RUN apt-get update && apt-get install -y \
    git \
    curl \
    wget \
# Add other dependencies here
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /workspace/${localWorkspaceFolderBasename}

# Keep the container running
CMD ["sleep", "infinity"]