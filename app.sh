#!/bin/bash

COMMAND=$1

BUILD_DIR="build"
SRC_DIR="."
SRC_FILES="$SRC_DIR/*.java $SRC_DIR/*/*.java"
MAIN_CLASS="Main"

clean() {
    echo "🧹 Cleaning build directory..."
    rm -rf "$BUILD_DIR"
    echo "✅ Clean complete."
}

build() {
    echo "🔨 Building project..."
    mkdir -p "$BUILD_DIR"
    javac -d "$BUILD_DIR" $SRC_FILES
    if [ $? -eq 0 ]; then
        echo "✅ Build successful!"
    else
        echo "❌ Build failed."
        exit 1
    fi
}

run() {
    if [ ! -d "$BUILD_DIR" ]; then
        echo "⚠️  Build directory not found. Run './app.sh --build' first."
        exit 1
    fi
    echo "🚀 Running program..."
    java -cp "$BUILD_DIR" "$MAIN_CLASS"
}

all() {
    clean
    build
    run
}

help() {
    echo "Usage: ./app.sh [--build | --run | --clean | --all | --help]"
    echo ""
    echo "  --build   Compile source files to build/"
    echo "  --run     Run the compiled program"
    echo "  --clean   Delete the build directory"
    echo "  --all     Clean, then build, then run the app"
    echo "  --help    Show this message"
}

case "$COMMAND" in
    --build) build ;;
    --run) run ;;
    --clean) clean ;;
    --all) all ;;
    --help | *) help ;;
esac
