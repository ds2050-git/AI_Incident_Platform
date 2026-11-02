CREATE TABLE IF NOT EXISTS incidents (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    urgency VARCHAR(50) NOT NULL,
    impact VARCHAR(50) NOT NULL,
    priority VARCHAR(50),
    ai_summary TEXT,
    ai_recommendation TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_priority ON incidents(priority);
CREATE INDEX idx_urgency ON incidents(urgency);