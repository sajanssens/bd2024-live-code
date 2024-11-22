function delaySync(ms: number): void {
    const start = Date.now();
    while (Date.now() - start < ms) {
        // Busy-wait loop
    }
}

function synchronousLoop(): void {
    const items = [1, 2, 3, 4, 5]; // Example array to iterate over

    for (const item of items) {
        console.log(`Processing item: ${item}`);
        delaySync(1000); // Wait for 1000ms
    }

    console.log("All items processed.");
}

synchronousLoop();
