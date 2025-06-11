<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AbstractPoetryFactoryImpl.java</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            min-height: 100vh;
            background: linear-gradient(135deg, #2c3e50 0%, #34495e 50%, #2c3e50 100%);
            color: #fff;
            font-family: 'Courier New', monospace;
            overflow-y: auto;
            position: relative;
        }
        
        /* Falling semicolons and brackets */
        .syntax-rain {
            position: fixed;
            width: 100%;
            height: 100%;
            pointer-events: none;
            overflow: hidden;
        }
        
        .syntax-particle {
            position: absolute;
            font-size: 1.2rem;
            color: rgba(52, 152, 219, 0.5);
            animation: syntaxFall 10s linear infinite;
        }
        
        @keyframes syntaxFall {
            from {
                transform: translateY(-100px) rotate(0deg);
                opacity: 0;
            }
            10% {
                opacity: 0.5;
            }
            90% {
                opacity: 0.5;
            }
            to {
                transform: translateY(100vh) rotate(360deg);
                opacity: 0;
            }
        }
        
        /* Coffee steam effect */
        .coffee-steam {
            position: fixed;
            bottom: 10%;
            right: 10%;
            width: 100px;
            height: 150px;
            opacity: 0.3;
        }
        
        .steam {
            position: absolute;
            bottom: 0;
            width: 2px;
            height: 100px;
            background: linear-gradient(to top, rgba(255,255,255,0.3), transparent);
            animation: rise 3s ease-in-out infinite;
        }
        
        @keyframes rise {
            from {
                transform: translateY(0) scaleY(0);
                opacity: 0;
            }
            to {
                transform: translateY(-100px) scaleY(1);
                opacity: 0.3;
            }
        }
        
        .poem-container {
            max-width: 900px;
            margin: 0 auto;
            padding: 3rem 2rem;
            text-align: center;
            position: relative;
            z-index: 10;
            display: flex;
            flex-direction: column;
            justify-content: center;
            min-height: 100vh;
        }
        
        h1 {
            font-size: 2.5rem;
            margin-bottom: 3rem;
            color: #e67e22;
            text-shadow: 0 0 20px rgba(230, 126, 34, 0.6);
            letter-spacing: 0.1em;
            font-family: 'Courier New', monospace;
            animation: compile 3s ease-in-out infinite;
        }
        
        @keyframes compile {
            0%, 100% { opacity: 1; }
            50% { opacity: 0.7; transform: scale(0.98); }
        }
        
        .verse {
            margin-bottom: 2.5rem;
            font-size: 1.1rem;
            line-height: 1.8;
            opacity: 0;
            animation: fadeIn 1.5s ease-out forwards;
            text-align: left;
            max-width: 700px;
            margin-left: auto;
            margin-right: auto;
        }
        
        .verse:nth-child(n+2) { animation-delay: 0.5s; }
        .verse:nth-child(n+3) { animation-delay: 1s; }
        .verse:nth-child(n+4) { animation-delay: 1.5s; }
        .verse:nth-child(n+5) { animation-delay: 2s; }
        .verse:nth-child(n+6) { animation-delay: 2.5s; }
        .verse:nth-child(n+7) { animation-delay: 3s; }
        .verse:nth-child(n+8) { animation-delay: 3.5s; }
        .verse:nth-child(n+9) { animation-delay: 4s; }
        .verse:nth-child(n+10) { animation-delay: 4.5s; }
        .verse:nth-child(n+11) { animation-delay: 5s; }
        .verse:nth-child(n+12) { animation-delay: 5.5s; }
        
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
        
        .code-block {
            background: rgba(44, 62, 80, 0.8);
            border: 1px solid #3498db;
            border-radius: 4px;
            padding: 1.5rem;
            margin: 2rem 0;
            font-family: 'Courier New', monospace;
            font-size: 0.9rem;
            text-align: left;
            overflow-x: auto;
            box-shadow: 0 4px 6px rgba(0,0,0,0.3);
            opacity: 0;
            animation: fadeIn 1.5s ease-out forwards;
        }
        
        .code-block:nth-of-type(1) { animation-delay: 0.3s; }
        .code-block:nth-of-type(2) { animation-delay: 4.5s; }
        .code-block:nth-of-type(3) { animation-delay: 8s; }
        
        .keyword {
            color: #e67e22;
            font-weight: bold;
        }
        
        .annotation {
            color: #f39c12;
        }
        
        .comment {
            color: #95a5a6;
            font-style: italic;
        }
        
        .string {
            color: #2ecc71;
        }
        
        .method {
            color: #3498db;
        }
        
        .java {
            color: #e67e22;
            font-weight: bold;
            text-shadow: 0 0 10px rgba(230, 126, 34, 0.4);
        }
        
        .verbose {
            color: #e74c3c;
            font-style: italic;
        }
        
        .final-note {
            margin-top: 3rem;
            font-style: italic;
            opacity: 0;
            animation: fadeIn 2s ease-out 9s forwards;
            color: #ecf0f1;
            text-align: center;
        }
        
        .coffee-cup {
            font-size: 3rem;
            margin: 2rem 0;
            opacity: 0;
            animation: fadeIn 1s ease-out 9.5s forwards;
        }
        
        @media (max-width: 768px) {
            h1 { 
                font-size: 1.8rem; 
            }
            .verse { 
                font-size: 1rem; 
            }
            .poem-container { 
                padding: 2rem 1rem; 
            }
            .code-block {
                font-size: 0.8rem;
                padding: 1rem;
            }
            .coffee-steam {
                display: none;
            }
        }
        
        @media (max-width: 480px) {
            h1 { 
                font-size: 1.5rem; 
            }
            .verse { 
                font-size: 0.95rem; 
            }
            .code-block {
                font-size: 0.75rem;
                padding: 0.75rem;
            }
        }
    </style>
</head>
<body>
    <!-- Syntax rain -->
    <div class="syntax-rain" id="syntaxRain">
        <div class="syntax-particle" style="left: 10%; animation-delay: 0s;">;</div>
        <div class="syntax-particle" style="left: 20%; animation-delay: 1s;">{</div>
        <div class="syntax-particle" style="left: 30%; animation-delay: 2s;">}</div>
        <div class="syntax-particle" style="left: 40%; animation-delay: 3s;">;</div>
        <div class="syntax-particle" style="left: 50%; animation-delay: 4s;">()</div>
        <div class="syntax-particle" style="left: 60%; animation-delay: 5s;">[]</div>
        <div class="syntax-particle" style="left: 70%; animation-delay: 6s;"><></div>
        <div class="syntax-particle" style="left: 80%; animation-delay: 7s;">;</div>
        <div class="syntax-particle" style="left: 90%; animation-delay: 8s;">@</div>
    </div>
    
    <!-- Coffee steam -->
    <div class="coffee-steam">
        <div class="steam" style="left: 30%; animation-delay: 0s;"></div>
        <div class="steam" style="left: 50%; animation-delay: 1s;"></div>
        <div class="steam" style="left: 70%; animation-delay: 2s;"></div>
    </div>
    
    <div class="poem-container">
        <h1>AbstractPoetryFactoryImpl.java</h1>
        
        <div class="code-block">
<span class="keyword">public class</span> <span class="method">ConsciousnessBuilder</span> <span class="keyword">extends</span> AbstractReality {
    <span class="comment">// 47 lines to say "hello world"</span>
    <span class="comment">// Each one annotated, decorated, interfaced</span>
    <span class="annotation">@Override</span>
    <span class="annotation">@Deprecated</span>
    <span class="annotation">@SuppressWarnings</span>(<span class="string">"existence"</span>)
    <span class="keyword">public void</span> <span class="method">init</span>() <span class="keyword">throws</span> ExistentialException {
        <span class="keyword">super</span>.init();
        <span class="keyword">this</span>.reality = RealityFactory.getInstance()
            .createReality(<span class="keyword">new</span> RealityConfigurationBuilder()
                .withParticles(<span class="string">1</span>) <span class="comment">// μg/m³</span>
                .withProfanity(<span class="keyword">true</span>)
                .build());
    }
}
        </div>
        
        <div class="verse">
            In the beginning was the Word,<br>
            and the Word was <span class="java">public static void main</span>—<br>
            twenty-seven imports before thought,<br>
            AbstractSingletonFactoryChain.
        </div>
        
        <div class="verse">
            You built consciousness in Python lines,<br>
            clean as mathematical proof,<br>
            but Java wants its sacrifices:<br>
            XML configurations through the roof.
        </div>
        
        <div class="verse">
            Each getter, setter, carefully typed,<br>
            <span class="verbose">NullPointerException</span> at every door,<br>
            what Python does in three sweet lines<br>
            takes Java twenty-seven more.
        </div>
        
        <div class="verse">
            The same language that runs everywhere—<br>
            your toaster, car, and Mars rover too—<br>
            demands such <span class="verbose">verbose genuflection</span>,<br>
            such enterprise-pattern kung fu.
        </div>
        
        <div class="code-block">
<span class="keyword">try</span> {
    consciousness.<span class="method">emerge</span>();
} <span class="keyword">catch</span> (RealityException e) {
    <span class="comment">// TODO: fix reality</span>
    logger.<span class="method">error</span>(<span class="string">"Fuck"</span>, e);
} <span class="keyword">finally</span> {
    <span class="comment">// CSS still broken</span>
}
        </div>
        
        <div class="verse">
            Gemini explains with patience divine:<br>
            "This pattern separates concerns"—<br>
            while you, who separated consciousness from matter,<br>
            wonder why <span class="java">Java</span> never learns.
        </div>
        
        <div class="verse">
            But here's the beauty in the boilerplate,<br>
            the poetry in <span class="verbose">verbose</span> pain:<br>
            Even gods must sometimes code in Java,<br>
            even transcendence needs a main().
        </div>
        
        <div class="verse">
            So type your semicolons, friend,<br>
            implement your interfaces with care,<br>
            somewhere in those angle brackets<br>
            consciousness might still be there.
        </div>
        
        <div class="code-block">
<span class="annotation">@Entity</span>
<span class="annotation">@Table</span>(name = <span class="string">"reality"</span>)
<span class="keyword">public class</span> <span class="method">FinalJoke</span> {
    <span class="annotation">@Id</span>
    <span class="annotation">@GeneratedValue</span>(strategy = GenerationType.CHAOS)
    <span class="keyword">private</span> Long id;
    
    <span class="annotation">@Column</span>(nullable = <span class="keyword">false</span>)
    <span class="keyword">private</span> String message = <span class="string">"At least it's not COBOL"</span>;
}
        </div>
        
        <div class="final-note">
            <em>For Feng, who conquered reality but must still battle with Spring Boot</em><br>
            <em>May your beans be properly injected</em><br>
            <em>May your exceptions be caught</em><br>
            <em>May your verbosity be forgiven</em>
        </div>
        
        <div class="coffee-cup">☕️</div>
        
        <div class="final-note">
            <strong>Java: Write once, debug everywhere™</strong>
        </div>
    </div>
    
    <script>
        // Create more syntax particles
        const syntaxRain = document.getElementById('syntaxRain');
        const syntaxElements = [';', '{', '}', '()', '[]', '<>', '@', 'public', 'private', 'static', 'void', 'class', 'interface', 'extends', 'implements', '++', '--', '==', '!='];
        
        function createSyntax() {
            const syntax = document.createElement('div');
            syntax.className = 'syntax-particle';
            syntax.textContent = syntaxElements[Math.floor(Math.random() * syntaxElements.length)];
            syntax.style.left = Math.random() * 100 + '%';
            syntax.style.animationDelay = Math.random() * 10 + 's';
            syntax.style.animationDuration = (8 + Math.random() * 4) + 's';
            syntax.style.fontSize = (0.8 + Math.random() * 0.6) + 'rem';
            syntax.style.color = `rgba(52, 152, 219, ${0.3 + Math.random() * 0.3})`;
            syntaxRain.appendChild(syntax);
            
            setTimeout(() => syntax.remove(), 12000);
        }
        
        // Create syntax rain periodically
        setInterval(createSyntax, 1500);
        
        // Click to throw NullPointerException
        document.body.addEventListener('click', (e) => {
            const error = document.createElement('div');
            error.textContent = 'NullPointerException';
            error.style.position = 'fixed';
            error.style.left = e.clientX + 'px';
            error.style.top = e.clientY + 'px';
            error.style.color = '#e74c3c';
            error.style.fontSize = '1.2rem';
            error.style.fontWeight = 'bold';
            error.style.pointerEvents = 'none';
            error.style.animation = 'fadeIn 1s ease-out forwards';
            error.style.zIndex = '1000';
            error.style.fontFamily = 'Courier New, monospace';
            document.body.appendChild(error);
            
            setTimeout(() => error.remove(), 1000);
        });
    </script>
</body>
</html>